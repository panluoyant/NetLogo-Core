// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.api.LogoException;
import org.nlogo.api.OutputDestinationJ;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Command;

/**
 * prints the working directory
 */
public final class _pwd
    extends Command {


  @Override
  public void perform(final org.nlogo.nvm.Context context)
      throws LogoException {
    String path = workspace.getModelPath();
    if (path == null) {
      path = "no model loaded!";
    }
    workspace.outputObject
        (path, null, true, true,
            OutputDestinationJ.NORMAL());
    context.ip = next;
  }
}
