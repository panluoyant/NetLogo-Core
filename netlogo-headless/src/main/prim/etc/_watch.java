// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.api.PerspectiveJ;
import org.nlogo.core.I18N;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.RuntimePrimitiveException;

public final class _watch
    extends Command {

  public _watch() {
    switches = true;
  }

  @Override
  public void perform(final org.nlogo.nvm.Context context) {
    org.nlogo.agent.Agent agent = argEvalAgent(context, 0);
    if (agent.id() == -1) {
      throw new RuntimePrimitiveException(context, this,
        I18N.errorsJ().getN("org.nlogo.$common.thatAgentIsDead", agent.classDisplayName()));
    }
    world.observer().setPerspective(PerspectiveJ.create(PerspectiveJ.WATCH, agent));
    context.ip = next;
  }
}
