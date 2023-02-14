package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class ParsingJson {
    @Test
    void parseFile() throws IOException {
        File file = new File ("src/test/resources/simple.json");
        ObjectMapper mp = new ObjectMapper();
        PersonalData personalData = mp.readValue(file, PersonalData.class);
        assertThat(personalData.firstName).isEqualTo("Rack");
        assertThat(personalData.lastName).isEqualTo("Jackon");
        assertThat(personalData.gender).isEqualTo("man");
        assertThat(personalData.age).isEqualTo(24);

    }
}
