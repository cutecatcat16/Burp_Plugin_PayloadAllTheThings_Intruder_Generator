package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class SSRFGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public SSRFGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "SSRF";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new SSRFPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}