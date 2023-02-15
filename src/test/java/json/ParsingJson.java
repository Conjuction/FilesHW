package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class ParsingJson {
    ClassLoader cl = ParsingJson.class.getClassLoader();

    @Test
    void parseFile() throws IOException {
        ObjectMapper mp = new ObjectMapper();
        try (
                InputStream resource = cl.getResourceAsStream("simple.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ) {
            PersonalData personalData = mp.readValue(reader, PersonalData.class);
            assertThat(personalData.firstName).isEqualTo("Rack");
            assertThat(personalData.lastName).isEqualTo("Jackon");
            assertThat(personalData.gender).isEqualTo("man");
            assertThat(personalData.age).isEqualTo(24);
            assertThat(personalData.address.streetAddress).isEqualTo(126);
            assertThat(personalData.address.city).isEqualTo("San Jone");
            assertThat(personalData.address.state).isEqualTo("CA");
            assertThat(personalData.address.postalCode).isEqualTo(394221);
        }
    }
}
