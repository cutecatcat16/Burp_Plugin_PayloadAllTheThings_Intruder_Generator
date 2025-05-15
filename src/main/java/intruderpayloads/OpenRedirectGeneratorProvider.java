package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class OpenRedirectGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public OpenRedirectGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "Open Redirect";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new OpenRedirectPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}