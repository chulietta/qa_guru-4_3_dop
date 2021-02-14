package action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTests {

    @Test
    @DisplayName("Drag&Drop with selenide actions")
    void selenideActionsTest() throws AWTException {
        //open page
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        Point b=$("#column-b").getLocation();
        new Robot().mouseMove(b.getX()+100,b.getY()+200);

        //move A rectangle instead B
        $("#column-a").dragAndDropTo($("#column-b"));
        //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(650,150).release().perform();

        //verify rectangles switched places
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
