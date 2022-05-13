// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.agent.Turtle;
import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;

public final class _left
    extends Command {
  public _left() {
    this.switches = true;
  }



  @Override
  public void perform(final Context context)
      throws LogoException {
    perform_1(context, argEvalDoubleValue(context, 0));
  }

  public void perform_1(final Context context, double delta) {
    ((Turtle) context.agent).turnRight(-delta);
    context.ip = next;
  }
}
