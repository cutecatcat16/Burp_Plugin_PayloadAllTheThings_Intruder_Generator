package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class InjectionsGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public InjectionsGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "Injections";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new InjectionsGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}