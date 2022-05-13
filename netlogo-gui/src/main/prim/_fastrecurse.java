// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim;

import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;

public final class _fastrecurse
    extends Command {
  private final _call original;

  public _fastrecurse(_call original) {
    this.original = original;
    token_$eq(original.token());
  }

  @Override
  public String toString() {
    return super.toString() + ":" + offset;
  }

  @Override
  public void perform(Context context) throws LogoException {
    perform_1(context);
  }

  public void perform_1(Context context) throws LogoException {
    if (context.atTopActivation()) {
      context.ip = offset;
    } else {
      // if we're inside an ask inside the current procedure, then we have
      // to do normal recursion, not "fast" tail recursion - ST 11/17/04
      original.perform(context);
    }
  }
}
