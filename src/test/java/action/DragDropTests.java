package action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTests {

    @Test
    @DisplayName("Drag&Drop with selenide actions")
    void selenideActionsTest() {
        //open page
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //move A rectangle instead B
        $("#column-a").dragAndDropTo($("#column-b"));
        //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(650,150).release().perform();

        //verify rectangles switched places
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
