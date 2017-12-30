package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Speaker {
  public String name;

  public void cg_init_Speaker_1(final String n1) {

    name = n1;
    return;
  }

  public Speaker(final String n1) {

    cg_init_Speaker_1(n1);
  }

  public String getName() {

    return name;
  }

  public Speaker() {}

  public String toString() {

    return "Speaker{" + "name := " + Utils.toString(name) + "}";
  }
}
