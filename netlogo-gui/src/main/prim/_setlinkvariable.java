// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim;

import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;

public final class _setlinkvariable
    extends Command {
  int vn = 0;

  public _setlinkvariable(_linkvariable original) {
    vn = original.vn();
    this.switches = true;
  }



  @Override
  public String toString() {
    if (world != null) {
      return super.toString() + ":" + world.linksOwnNameAt(vn);
    } else {
      return super.toString() + ":" + vn;
    }
  }

  @Override
  public void perform(final Context context)
      throws LogoException {
    Object value = args[0].report(context);
    try {
      context.agent.setLinkVariable(vn, value);
    } catch (org.nlogo.api.AgentException ex) {
      throw new RuntimePrimitiveException(context, this, ex.getMessage());
    }
    context.ip = next;
  }

  public void perform_1(final org.nlogo.nvm.Context context, Object value) throws LogoException {
    try {
      context.agent.setLinkVariable(vn, value);
    } catch (org.nlogo.api.AgentException ex) {
      throw new RuntimePrimitiveException(context, this, ex.getMessage());
    }
    context.ip = next;
  }
}
