package com.testvagrant.stepdefs.builders;

import com.testvagrant.stepdefs.finder.Element;

public class ElementBuilder {

    private Element element;

    public ElementBuilder() {
        element = new Element();
    }

    public ElementBuilder withElementName(String elementName) {
        element.setElementName(elementName);
        return this;
    }

    public ElementBuilder withIdentifier(String identifier){
        element.setIdentifier(identifier);
        return this;
    }

    public ElementBuilder withValue(String value) {
        element.setValue(value);
        return this;
    }

    public ElementBuilder withWaitFor(String waitFor) {
        element.setWaitFor(waitFor);
        return this;
    }

    public ElementBuilder withReferTo(String referTo) {
        element.setReferTo(referTo);
        return this;
    }

    public Element build() {
        return  element;
    }
}
