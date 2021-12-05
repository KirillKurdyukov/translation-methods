package error;

public class GenerateException extends RuntimeException {
    public GenerateException(String message) {
        super("Generation error: " + message);
    }
}
