package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

public class MyPayloadGeneratorProvider implements PayloadGeneratorProvider
{
    @Override
    public String displayName()
    {
        return "My custom payloads";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        return new MyPayloadGenerator();
    }
}