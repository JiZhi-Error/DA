package rx.internal.util.unsafe;

abstract class SpscArrayQueueColdField<E> extends ConcurrentCircularArrayQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int lookAheadStep;

    public SpscArrayQueueColdField(int i2) {
        super(i2);
        this.lookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }
}
