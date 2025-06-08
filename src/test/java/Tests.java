import org.junit.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;

public class Tests {
    @Test
    public void shouldSubmitForm() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=agreement]").click();
        $("button").click();

        $("[data-test-id=order-success]")
                .shouldHave(Condition.exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
