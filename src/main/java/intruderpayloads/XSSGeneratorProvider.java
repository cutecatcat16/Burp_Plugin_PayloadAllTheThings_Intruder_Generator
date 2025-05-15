package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class XSSGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public XSSGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "XSS";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new XSSPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}