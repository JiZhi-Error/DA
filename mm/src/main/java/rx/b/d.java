package rx.b;

import java.util.concurrent.Callable;

public interface d<R> extends Callable<R> {
    @Override // java.util.concurrent.Callable
    R call();
}
