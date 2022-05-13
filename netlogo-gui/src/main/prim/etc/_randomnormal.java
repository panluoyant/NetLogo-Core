// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.core.I18N;
import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;
import org.nlogo.nvm.Reporter;

public final class _randomnormal extends Reporter {


  @Override
  public Object report(Context context) throws LogoException {
    return report_1(context,
        argEvalDoubleValue(context, 0),
        argEvalDoubleValue(context, 1));
  }

  public double report_1(Context context, double mean, double sdev) throws LogoException {
    if (sdev < 0) {
      throw new RuntimePrimitiveException(
          context, this, I18N.errorsJ().get("org.nlogo.prim.etc._randomNormal.secondInputNotNegative"));

    }
    return validDouble(mean + sdev * context.job.random.nextGaussian(), context);
  }
}
