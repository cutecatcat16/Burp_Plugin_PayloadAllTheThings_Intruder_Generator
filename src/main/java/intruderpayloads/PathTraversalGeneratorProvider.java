package intruderpayloads;

import burp.api.montoya.intruder.AttackConfiguration;
import burp.api.montoya.intruder.PayloadGenerator;
import burp.api.montoya.intruder.PayloadGeneratorProvider;

import java.io.IOException;

public class PathTraversalGeneratorProvider implements PayloadGeneratorProvider
{
    private final String name;

    public PathTraversalGeneratorProvider(String name) {
        this.name = name;
    }
    @Override
    public String displayName()
    {
        return "Path Traversal";
    }

    @Override
    public PayloadGenerator providePayloadGenerator(AttackConfiguration attackConfiguration)
    {
        try {
            return new PathTraversalPayloadGenerator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}