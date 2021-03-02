package com.tencent.mm.sdk.event;

public abstract class IEvent {
    private int __eventID = 0;
    public Runnable callback = null;
    protected boolean order;

    /* access modifiers changed from: package-private */
    public int __getEventID() {
        if (this.__eventID == 0) {
            this.__eventID = getClass().getName().hashCode();
        }
        return this.__eventID;
    }

    public boolean getOrder() {
        return this.order;
    }
}
