// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim;

import org.nlogo.agent.AgentSet;
import org.nlogo.core.I18N;
import org.nlogo.api.LogoException;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.ArgumentTypeException;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;
import org.nlogo.nvm.Reporter;

public final class _oneof
    extends Reporter {
  @Override
  public Object report(final Context context) throws LogoException {
    Object obj = args[0].report(context);
    if (obj instanceof LogoList) {
      LogoList list = (LogoList) obj;
      int size = list.size();
      if (size == 0) {
        throw new RuntimePrimitiveException(context, this,
            I18N.errorsJ().getN("org.nlogo.prim.etc.$common.emptyListInput", displayName()));
      }
      return list.get(context.job.random.nextInt(size));
    } else if (obj instanceof AgentSet) {
      AgentSet agents = (AgentSet) obj;
      int count = agents.count();
      if (count == 0) {
        return org.nlogo.core.Nobody$.MODULE$;
      } else {
        return agents.randomOne(count, context.job.random.nextInt(count));
      }
    } else {
      throw new ArgumentTypeException
          (context, this, 0, Syntax.ListType() | Syntax.AgentsetType(), obj);
    }
  }



  public Object report_1(Context context, AgentSet agents) {
    int count = agents.count();
    if (count == 0) {
      return org.nlogo.core.Nobody$.MODULE$;
    } else {
      return agents.randomOne(count, context.job.random.nextInt(count));
    }
  }

  public Object report_2(Context context, LogoList list) throws LogoException {
    int size = list.size();
    if (size == 0) {
      throw new RuntimePrimitiveException(context, this,
          I18N.errorsJ().getN("org.nlogo.prim.etc.$common.emptyListInput", displayName()));
    }
    return list.get(context.job.random.nextInt(size));
  }

  public Object report_3(Context context, Object obj) throws LogoException {
    if (obj instanceof LogoList) {
      LogoList list = (LogoList) obj;
      int size = list.size();
      if (size == 0) {
        throw new RuntimePrimitiveException(context, this,
            I18N.errorsJ().getN("org.nlogo.prim.etc.$common.emptyListInput", displayName()));
      }
      return list.get(context.job.random.nextInt(size));
    } else if (obj instanceof AgentSet) {
      AgentSet agents = (AgentSet) obj;
      int count = agents.count();
      if (count == 0) {
        return org.nlogo.core.Nobody$.MODULE$;
      } else {
        return agents.randomOne(count, context.job.random.nextInt(count));
      }
    } else {
      throw new ArgumentTypeException(context, this, 0,
          Syntax.ListType() | Syntax.AgentsetType(), obj);
    }
  }

}
