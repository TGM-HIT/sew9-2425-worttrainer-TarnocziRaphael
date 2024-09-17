package at.tarnoczi.model;

/**
 * interface, so other file-formats will also be supported and easily be changed
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public interface StrategyStorage {
    public void load(WordTrainer wordTrainer);
    public void store(WordTrainer wordTrainer);
}
