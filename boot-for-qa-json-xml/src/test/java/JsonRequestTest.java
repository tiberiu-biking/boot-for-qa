import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * @author Tiberiu Popa
 * @since 6/22/2018
 */
public class JsonRequestTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void demoSerialization() {
        reque
        objectMapper.writer().writeValueAsString(request);
    }
}
