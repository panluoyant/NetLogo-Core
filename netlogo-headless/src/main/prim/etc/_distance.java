// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.agent.Agent;
import org.nlogo.core.I18N;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;
import org.nlogo.nvm.Reporter;

public final class _distance extends Reporter {
    @Override
  public Object report(Context context) {
    return report_1(context, argEvalAgent(context, 0));
  }

  public double report_1(Context context, Agent otherAgent) {
    if (otherAgent instanceof org.nlogo.agent.Link) {
      throw new RuntimePrimitiveException
          (context, this, I18N.errorsJ().get("org.nlogo.prim.etc.$common.expectedTurtleOrPatchButGotLink"));
    }
    if (otherAgent.id() == -1) {
      throw new RuntimePrimitiveException(context, this,
        I18N.errorsJ().getN("org.nlogo.$common.thatAgentIsDead", otherAgent.classDisplayName()));
    }
    return world.protractor().distance(context.agent, otherAgent, true); // true = wrap
  }
}
