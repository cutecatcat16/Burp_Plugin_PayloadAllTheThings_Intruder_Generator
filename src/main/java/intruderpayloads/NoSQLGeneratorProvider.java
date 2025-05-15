package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class NoSQLGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public NoSQLGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "No SQL Injection";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new NoSQLPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}