package com.ms4i.dp.behavioral.strategy.singlefile;

public class FinderMain {

    public static void main(String[] args) {
        Finder finder = new Finder(new FinderByNameStrategy());
        finder.find();
        finder.setStrategy(new FinderByIdStrategy());
        finder.find();
    }
}

interface FinderStrategy {
    String find();
}

class FinderByIdStrategy implements FinderStrategy {
    FinderByIdStrategy() {
    }

    public String find() {
        return "Find by id";
    }
}

class FinderByNameStrategy implements FinderStrategy {
    FinderByNameStrategy() {
    }

    public String find() {
        return "Find by name";
    }
}

class Finder {
    private FinderStrategy strategy;

    public Finder(FinderStrategy strategy) {
        this.strategy = strategy;
    }

    public void find() {
        System.out.println(this.strategy.find());
    }

    public void setStrategy(FinderStrategy strategy) {
        this.strategy = strategy;
    }
}