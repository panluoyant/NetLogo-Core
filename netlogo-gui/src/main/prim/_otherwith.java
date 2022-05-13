// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim;

import org.nlogo.agent.Agent;
import org.nlogo.agent.AgentIterator;
import org.nlogo.agent.AgentSet;
import org.nlogo.api.Dump;
import org.nlogo.core.I18N;
import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;
import org.nlogo.nvm.Reporter;

import java.util.ArrayList;
import java.util.List;

public final class _otherwith
    extends Reporter {


  @Override
  public Object report(final Context context)
      throws LogoException {
    return report_1(context, argEvalAgentSet(context, 0),
        args[1]);
  }

  public AgentSet report_1(final Context context, AgentSet sourceSet, Reporter reporterBlock)
      throws LogoException {
    Context freshContext = new Context(context, sourceSet);
    List<Agent> result = new ArrayList<Agent>();
    reporterBlock.checkAgentSetClass(sourceSet, context);
    for (AgentIterator iter = sourceSet.iterator(); iter.hasNext();) {
      Agent tester = iter.next();
      if (tester == context.agent) {
        continue;
      }
      Object value = freshContext.evaluateReporter(tester, reporterBlock);
      if (!(value instanceof Boolean)) {
        throw new RuntimePrimitiveException
            (context, this, I18N.errorsJ().getN("org.nlogo.prim.$common.expectedBooleanValue",
                displayName(), Dump.logoObject(tester), Dump.logoObject(value)));
      }
      if (((Boolean) value).booleanValue()) {
        result.add(tester);
      }
    }
    return AgentSet.fromArray(sourceSet.kind(), result.toArray(new Agent[result.size()]));
  }
}
