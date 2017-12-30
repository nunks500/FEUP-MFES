package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class startup {
  public String name;
  public String CountryOfOrigin;

  public void cg_init_startup_1(final String n1, final String n2) {

    name = n1;
    CountryOfOrigin = n2;
    return;
  }

  public startup(final String n1, final String n2) {

    cg_init_startup_1(n1, n2);
  }

  public String getName() {

    return name;
  }

  public String getCountryOfOrigin() {

    return CountryOfOrigin;
  }

  public startup() {}

  public String toString() {

    return "startup{"
        + "name := "
        + Utils.toString(name)
        + ", CountryOfOrigin := "
        + Utils.toString(CountryOfOrigin)
        + "}";
  }
}
