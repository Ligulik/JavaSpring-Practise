package pl.maciek_rychlinski;

import javax.validation.GroupSequence;

@GroupSequence({Draft.class, Complete.class})
public interface Full {
}
