package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class News {
  public String title;
  public String content;
  public Types.Date timeOfPublish;

  public void cg_init_News_1(final String n1, final String n2, final Types.Date n3) {

    title = n1;
    content = n2;
    timeOfPublish = Utils.copy(n3);
    return;
  }

  public News(final String n1, final String n2, final Types.Date n3) {

    cg_init_News_1(n1, n2, Utils.copy(n3));
  }

  public String getTitle() {

    return title;
  }

  public News() {}

  public String toString() {

    return "News{"
        + "title := "
        + Utils.toString(title)
        + ", content := "
        + Utils.toString(content)
        + ", timeOfPublish := "
        + Utils.toString(timeOfPublish)
        + "}";
  }
}
