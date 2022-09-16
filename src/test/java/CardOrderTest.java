import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    public void formForOrder() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").setValue("Миша Фокин");
        $("[data-test-id='phone'] input").setValue("+79990007775");
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $("[data-test-id='order-success']").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
