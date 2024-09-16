package at.tarnoczi.model;

/**
 * Interface für Strategy-Pattern
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public interface StrategyStorage {
    public void load(WordTrainer wordTrainer);
    public void store(WordTrainer wordTrainer);
}
