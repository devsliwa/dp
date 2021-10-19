package com.ms4i.dp.behavioral.strategy.singlefile;

import java.util.Optional;

public class FinderMainOptional {

    public static void main(String[] args) {
        FinderOptional finder = new FinderOptional(new FinderOptionalByNameStrategy());
        finder.find();
        finder.changeStrategy(new FinderOptionalByIdStrategy());
        finder.find();
    }
}

interface FinderOptionalStrategy {
    String find();
}

class FinderOptionalByIdStrategy implements FinderOptionalStrategy {
    FinderOptionalByIdStrategy() {
    }

    public String find() {
        return "Find by id";
    }
}

class FinderOptionalByNameStrategy implements FinderOptionalStrategy {
    FinderOptionalByNameStrategy() {
    }

    public String find() {
        return "Find by name";
    }
}

class FinderOptional {
    private Optional<FinderOptionalStrategy> strategy;

    public FinderOptional(FinderOptionalStrategy strategy) {
        this.strategy = Optional.ofNullable(strategy);
    }

    public void find() {
        System.out.println(this.strategy.map(FinderOptionalStrategy::find)
                .orElseThrow(() -> new IllegalArgumentException("Strategy not set")));
    }

    public void changeStrategy(FinderOptionalStrategy strategy) {
        this.strategy = Optional.ofNullable(strategy);
    }
}