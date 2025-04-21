package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class MyPayloadGeneratorProvider implements PayloadGeneratorProvider
{
    @Override
    public String displayName()
    {
        return "PayloadAllTheThings";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new MyPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}