package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class CookiesGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public CookiesGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "Cookies";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new CookiesPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}