// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim;

import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;
import org.nlogo.nvm.Reporter;

public final class _turtlevariable
    extends Reporter {
  public int vn = 0;

  public _turtlevariable(int vn) {
    this.vn = vn;
  }



  @Override
  public String toString() {
    if (world != null) {
      return super.toString() + ":" + world.turtlesOwnNameAt(vn);
    } else {
      return super.toString() + ":" + vn;
    }
  }

  @Override
  public Object report(Context context) throws LogoException {
    return report_1(context);
  }

  public Object report_1(Context context) throws LogoException {
    try {
      return context.agent.getTurtleVariable(vn);
    } catch (org.nlogo.api.AgentException ex) {
      throw new RuntimePrimitiveException(context, this, ex.getMessage());
    }
  }

}
