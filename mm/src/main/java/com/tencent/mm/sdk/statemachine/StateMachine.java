package com.tencent.mm.sdk.statemachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class StateMachine {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    public static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    private String mName;
    private volatile SmHandler mSmHandler;
    private volatile HandlerThread mSmThread;

    public static class LogRec {
        private IState mDstState;
        private String mInfo;
        private IState mOrgState;
        private StateMachine mSm;
        private IState mState;
        private long mTime;
        private int mWhat;

        LogRec(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            AppMethodBeat.i(158011);
            update(stateMachine, message, str, iState, iState2, iState3);
            AppMethodBeat.o(158011);
        }

        public void update(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            AppMethodBeat.i(158012);
            this.mSm = stateMachine;
            this.mTime = System.currentTimeMillis();
            this.mWhat = message != null ? message.what : 0;
            this.mInfo = str;
            this.mState = iState;
            this.mOrgState = iState2;
            this.mDstState = iState3;
            AppMethodBeat.o(158012);
        }

        public long getTime() {
            return this.mTime;
        }

        public long getWhat() {
            return (long) this.mWhat;
        }

        public String getInfo() {
            return this.mInfo;
        }

        public IState getState() {
            return this.mState;
        }

        public IState getDestState() {
            return this.mDstState;
        }

        public IState getOriginalState() {
            return this.mOrgState;
        }

        public String toString() {
            AppMethodBeat.i(158013);
            StringBuilder sb = new StringBuilder();
            sb.append("time=");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.mTime);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", instance, instance, instance, instance, instance, instance));
            sb.append(" processed=");
            sb.append(this.mState == null ? "<null>" : this.mState.getName());
            sb.append(" org=");
            sb.append(this.mOrgState == null ? "<null>" : this.mOrgState.getName());
            sb.append(" dest=");
            sb.append(this.mDstState == null ? "<null>" : this.mDstState.getName());
            sb.append(" what=");
            String whatToString = this.mSm != null ? this.mSm.getWhatToString(this.mWhat) : "";
            if (TextUtils.isEmpty(whatToString)) {
                sb.append(this.mWhat);
                sb.append("(0x");
                sb.append(Integer.toHexString(this.mWhat));
                sb.append(")");
            } else {
                sb.append(whatToString);
            }
            if (!TextUtils.isEmpty(this.mInfo)) {
                sb.append(" ");
                sb.append(this.mInfo);
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(158013);
            return sb2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class LogRecords {
        private static final int DEFAULT_SIZE = 20;
        private int mCount;
        private boolean mLogOnlyTransitions;
        private Vector<LogRec> mLogRecVector;
        private int mMaxSize;
        private int mOldestIndex;

        private LogRecords() {
            AppMethodBeat.i(158014);
            this.mLogRecVector = new Vector<>();
            this.mMaxSize = 20;
            this.mOldestIndex = 0;
            this.mCount = 0;
            this.mLogOnlyTransitions = false;
            AppMethodBeat.o(158014);
        }

        /* access modifiers changed from: package-private */
        public synchronized void setSize(int i2) {
            AppMethodBeat.i(230443);
            this.mMaxSize = i2;
            this.mCount = 0;
            this.mLogRecVector.clear();
            AppMethodBeat.o(230443);
        }

        /* access modifiers changed from: package-private */
        public synchronized void setLogOnlyTransitions(boolean z) {
            this.mLogOnlyTransitions = z;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean logOnlyTransitions() {
            return this.mLogOnlyTransitions;
        }

        /* access modifiers changed from: package-private */
        public synchronized int size() {
            int size;
            AppMethodBeat.i(230444);
            size = this.mLogRecVector.size();
            AppMethodBeat.o(230444);
            return size;
        }

        /* access modifiers changed from: package-private */
        public synchronized int count() {
            return this.mCount;
        }

        /* access modifiers changed from: package-private */
        public synchronized void cleanup() {
            AppMethodBeat.i(158015);
            this.mLogRecVector.clear();
            AppMethodBeat.o(158015);
        }

        /* access modifiers changed from: package-private */
        public synchronized LogRec get(int i2) {
            LogRec logRec;
            AppMethodBeat.i(230445);
            int i3 = this.mOldestIndex + i2;
            if (i3 >= this.mMaxSize) {
                i3 -= this.mMaxSize;
            }
            if (i3 >= size()) {
                logRec = null;
                AppMethodBeat.o(230445);
            } else {
                logRec = this.mLogRecVector.get(i3);
                AppMethodBeat.o(230445);
            }
            return logRec;
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            AppMethodBeat.i(158016);
            this.mCount++;
            if (this.mLogRecVector.size() < this.mMaxSize) {
                this.mLogRecVector.add(new LogRec(stateMachine, message, str, iState, iState2, iState3));
                AppMethodBeat.o(158016);
            } else {
                LogRec logRec = this.mLogRecVector.get(this.mOldestIndex);
                this.mOldestIndex++;
                if (this.mOldestIndex >= this.mMaxSize) {
                    this.mOldestIndex = 0;
                }
                logRec.update(stateMachine, message, str, iState, iState2, iState3);
                AppMethodBeat.o(158016);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class SmHandler extends Handler {
        private static final Object mSmHandlerObj = new Object();
        private boolean mDbg;
        private ArrayList<Message> mDeferredMessages;
        private State mDestState;
        private HaltingState mHaltingState;
        private boolean mHasQuit;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        private LogRecords mLogRecords;
        private Message mMsg;
        private QuittingState mQuittingState;
        private StateMachine mSm;
        private HashMap<State, StateInfo> mStateInfo;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;

        static /* synthetic */ Message access$1000(SmHandler smHandler) {
            AppMethodBeat.i(230456);
            Message currentMessage = smHandler.getCurrentMessage();
            AppMethodBeat.o(230456);
            return currentMessage;
        }

        static /* synthetic */ IState access$1100(SmHandler smHandler) {
            AppMethodBeat.i(230457);
            IState currentState = smHandler.getCurrentState();
            AppMethodBeat.o(230457);
            return currentState;
        }

        static /* synthetic */ void access$1200(SmHandler smHandler, IState iState) {
            AppMethodBeat.i(158031);
            smHandler.transitionTo(iState);
            AppMethodBeat.o(158031);
        }

        static /* synthetic */ void access$1400(SmHandler smHandler, Message message) {
            AppMethodBeat.i(230458);
            smHandler.deferMessage(message);
            AppMethodBeat.o(230458);
        }

        static /* synthetic */ boolean access$2100(SmHandler smHandler, Message message) {
            AppMethodBeat.i(230459);
            boolean isQuit = smHandler.isQuit(message);
            AppMethodBeat.o(230459);
            return isQuit;
        }

        static /* synthetic */ void access$2200(SmHandler smHandler) {
            AppMethodBeat.i(158033);
            smHandler.quit();
            AppMethodBeat.o(158033);
        }

        static /* synthetic */ void access$2300(SmHandler smHandler) {
            AppMethodBeat.i(158034);
            smHandler.quitNow();
            AppMethodBeat.o(158034);
        }

        static /* synthetic */ boolean access$2400(SmHandler smHandler) {
            AppMethodBeat.i(230460);
            boolean isDbg = smHandler.isDbg();
            AppMethodBeat.o(230460);
            return isDbg;
        }

        static /* synthetic */ void access$2500(SmHandler smHandler, boolean z) {
            AppMethodBeat.i(230461);
            smHandler.setDbg(z);
            AppMethodBeat.o(230461);
        }

        static /* synthetic */ void access$2600(SmHandler smHandler) {
            AppMethodBeat.i(158035);
            smHandler.completeConstruction();
            AppMethodBeat.o(158035);
        }

        static /* synthetic */ StateInfo access$800(SmHandler smHandler, State state, State state2) {
            AppMethodBeat.i(230455);
            StateInfo addState = smHandler.addState(state, state2);
            AppMethodBeat.o(230455);
            return addState;
        }

        static /* synthetic */ void access$900(SmHandler smHandler, State state) {
            AppMethodBeat.i(158030);
            smHandler.setInitialState(state);
            AppMethodBeat.o(158030);
        }

        static {
            AppMethodBeat.i(158036);
            AppMethodBeat.o(158036);
        }

        /* access modifiers changed from: package-private */
        public class StateInfo {
            boolean active;
            StateInfo parentStateInfo;
            State state;

            private StateInfo() {
            }

            public String toString() {
                String name;
                AppMethodBeat.i(158018);
                StringBuilder append = new StringBuilder("state=").append(this.state.getName()).append(",active=").append(this.active).append(",parent=");
                if (this.parentStateInfo == null) {
                    name = BuildConfig.COMMAND;
                } else {
                    name = this.parentStateInfo.state.getName();
                }
                String sb = append.append(name).toString();
                AppMethodBeat.o(158018);
                return sb;
            }
        }

        /* access modifiers changed from: package-private */
        public class HaltingState extends State {
            private HaltingState() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public boolean processMessage(Message message) {
                AppMethodBeat.i(158017);
                SmHandler.this.mSm.haltedProcessMessage(message);
                AppMethodBeat.o(158017);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public class QuittingState extends State {
            private QuittingState() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public boolean processMessage(Message message) {
                return false;
            }
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(158019);
            if (!this.mHasQuit) {
                if (this.mDbg) {
                    this.mSm.log("handleMessage: E msg.what=" + message.what);
                }
                this.mMsg = message;
                State state = null;
                if (this.mIsConstructionCompleted) {
                    state = processMsg(message);
                } else if (!this.mIsConstructionCompleted && this.mMsg.what == -2 && this.mMsg.obj == mSmHandlerObj) {
                    this.mIsConstructionCompleted = true;
                    invokeEnterMethods(0);
                } else {
                    RuntimeException runtimeException = new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: ".concat(String.valueOf(message)));
                    AppMethodBeat.o(158019);
                    throw runtimeException;
                }
                performTransitions(state, message);
                if (this.mDbg && this.mSm != null) {
                    this.mSm.log("handleMessage: X");
                }
            }
            AppMethodBeat.o(158019);
        }

        private void performTransitions(State state, Message message) {
            AppMethodBeat.i(158020);
            State state2 = this.mStateStack[this.mStateStackTopIndex].state;
            boolean z = this.mSm.recordLogRec(this.mMsg) && message.obj != mSmHandlerObj;
            if (this.mLogRecords.logOnlyTransitions()) {
                if (this.mDestState != null) {
                    this.mLogRecords.add(this.mSm, this.mMsg, this.mSm.getLogRecString(this.mMsg), state, state2, this.mDestState);
                }
            } else if (z) {
                this.mLogRecords.add(this.mSm, this.mMsg, this.mSm.getLogRecString(this.mMsg), state, state2, this.mDestState);
            }
            State state3 = this.mDestState;
            if (state3 != null) {
                while (true) {
                    if (this.mDbg) {
                        this.mSm.log("handleMessage: new destination call exit/enter");
                    }
                    invokeExitMethods(setupTempStateStackWithStatesToEnter(state3));
                    invokeEnterMethods(moveTempStateStackToStateStack());
                    moveDeferredMessageAtFrontOfQueue();
                    if (state3 == this.mDestState) {
                        break;
                    }
                    state3 = this.mDestState;
                }
                this.mDestState = null;
            }
            if (state3 != null) {
                if (state3 == this.mQuittingState) {
                    this.mSm.onQuitting();
                    cleanupAfterQuitting();
                    AppMethodBeat.o(158020);
                    return;
                } else if (state3 == this.mHaltingState) {
                    this.mSm.onHalting();
                }
            }
            AppMethodBeat.o(158020);
        }

        private final void cleanupAfterQuitting() {
            AppMethodBeat.i(230446);
            if (this.mSm.mSmThread != null) {
                getLooper().quit();
                this.mSm.mSmThread = null;
            }
            this.mSm.mSmHandler = null;
            this.mSm = null;
            this.mMsg = null;
            this.mLogRecords.cleanup();
            this.mStateStack = null;
            this.mTempStateStack = null;
            this.mStateInfo.clear();
            this.mInitialState = null;
            this.mDestState = null;
            this.mDeferredMessages.clear();
            this.mHasQuit = true;
            AppMethodBeat.o(230446);
        }

        private final void completeConstruction() {
            int i2;
            AppMethodBeat.i(230447);
            if (this.mDbg) {
                this.mSm.log("completeConstruction: E");
            }
            int i3 = 0;
            for (StateInfo stateInfo : this.mStateInfo.values()) {
                int i4 = 0;
                while (stateInfo != null) {
                    stateInfo = stateInfo.parentStateInfo;
                    i4++;
                }
                if (i3 < i4) {
                    i2 = i4;
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
            if (this.mDbg) {
                this.mSm.log("completeConstruction: maxDepth=".concat(String.valueOf(i3)));
            }
            this.mStateStack = new StateInfo[i3];
            this.mTempStateStack = new StateInfo[i3];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
            if (this.mDbg) {
                this.mSm.log("completeConstruction: X");
            }
            AppMethodBeat.o(230447);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 122
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        private final com.tencent.mm.sdk.statemachine.State processMsg(android.os.Message r6) {
            /*
            // Method dump skipped, instructions count: 116
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.statemachine.StateMachine.SmHandler.processMsg(android.os.Message):com.tencent.mm.sdk.statemachine.State");
        }

        private final void invokeExitMethods(StateInfo stateInfo) {
            AppMethodBeat.i(158022);
            while (this.mStateStackTopIndex >= 0 && this.mStateStack[this.mStateStackTopIndex] != stateInfo) {
                State state = this.mStateStack[this.mStateStackTopIndex].state;
                if (this.mDbg) {
                    this.mSm.log("invokeExitMethods: " + state.getName());
                }
                state.exit();
                this.mStateStack[this.mStateStackTopIndex].active = false;
                this.mStateStackTopIndex--;
            }
            AppMethodBeat.o(158022);
        }

        private final void invokeEnterMethods(int i2) {
            AppMethodBeat.i(158023);
            while (i2 <= this.mStateStackTopIndex) {
                if (this.mDbg) {
                    this.mSm.log("invokeEnterMethods: " + this.mStateStack[i2].state.getName());
                }
                this.mStateStack[i2].state.enter();
                this.mStateStack[i2].active = true;
                i2++;
            }
            AppMethodBeat.o(158023);
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            AppMethodBeat.i(158024);
            for (int size = this.mDeferredMessages.size() - 1; size >= 0; size--) {
                Message message = this.mDeferredMessages.get(size);
                if (this.mDbg) {
                    this.mSm.log("moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.mDeferredMessages.clear();
            AppMethodBeat.o(158024);
        }

        private final int moveTempStateStackToStateStack() {
            AppMethodBeat.i(158025);
            int i2 = this.mStateStackTopIndex + 1;
            int i3 = i2;
            for (int i4 = this.mTempStateStackCount - 1; i4 >= 0; i4--) {
                if (this.mDbg) {
                    this.mSm.log("moveTempStackToStateStack: i=" + i4 + ",j=" + i3);
                }
                this.mStateStack[i3] = this.mTempStateStack[i4];
                i3++;
            }
            this.mStateStackTopIndex = i3 - 1;
            if (this.mDbg) {
                this.mSm.log("moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + i2 + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
            }
            AppMethodBeat.o(158025);
            return i2;
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            AppMethodBeat.i(230448);
            this.mTempStateStackCount = 0;
            StateInfo stateInfo = this.mStateInfo.get(state);
            do {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i2 = this.mTempStateStackCount;
                this.mTempStateStackCount = i2 + 1;
                stateInfoArr[i2] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    break;
                }
            } while (!stateInfo.active);
            if (this.mDbg) {
                this.mSm.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + stateInfo);
            }
            AppMethodBeat.o(230448);
            return stateInfo;
        }

        private final void setupInitialStateStack() {
            AppMethodBeat.i(230449);
            if (this.mDbg) {
                this.mSm.log("setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
            }
            StateInfo stateInfo = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
            while (stateInfo != null) {
                this.mTempStateStack[this.mTempStateStackCount] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                this.mTempStateStackCount++;
            }
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
            AppMethodBeat.o(230449);
        }

        private final Message getCurrentMessage() {
            return this.mMsg;
        }

        private final IState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        private final StateInfo addState(State state, State state2) {
            StateInfo stateInfo;
            String name;
            AppMethodBeat.i(230450);
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                StringBuilder append = new StringBuilder("addStateInternal: E state=").append(state.getName()).append(",parent=");
                if (state2 == null) {
                    name = "";
                } else {
                    name = state2.getName();
                }
                stateMachine.log(append.append(name).toString());
            }
            if (state2 != null) {
                StateInfo stateInfo2 = this.mStateInfo.get(state2);
                stateInfo = stateInfo2 == null ? addState(state2, null) : stateInfo2;
            } else {
                stateInfo = null;
            }
            StateInfo stateInfo3 = this.mStateInfo.get(state);
            if (stateInfo3 == null) {
                stateInfo3 = new StateInfo();
                this.mStateInfo.put(state, stateInfo3);
            }
            if (stateInfo3.parentStateInfo == null || stateInfo3.parentStateInfo == stateInfo) {
                stateInfo3.state = state;
                stateInfo3.parentStateInfo = stateInfo;
                stateInfo3.active = false;
                if (this.mDbg) {
                    this.mSm.log("addStateInternal: X stateInfo: ".concat(String.valueOf(stateInfo3)));
                }
                AppMethodBeat.o(230450);
                return stateInfo3;
            }
            RuntimeException runtimeException = new RuntimeException("state already added");
            AppMethodBeat.o(230450);
            throw runtimeException;
        }

        private SmHandler(Looper looper, StateMachine stateMachine) {
            super(looper);
            AppMethodBeat.i(158027);
            this.mHasQuit = false;
            this.mDbg = false;
            this.mLogRecords = new LogRecords();
            this.mStateStackTopIndex = -1;
            this.mHaltingState = new HaltingState();
            this.mQuittingState = new QuittingState();
            this.mStateInfo = new HashMap<>();
            this.mDeferredMessages = new ArrayList<>();
            this.mSm = stateMachine;
            addState(this.mHaltingState, null);
            addState(this.mQuittingState, null);
            AppMethodBeat.o(158027);
        }

        private final void setInitialState(State state) {
            AppMethodBeat.i(230451);
            if (this.mDbg) {
                this.mSm.log("setInitialState: initialState=" + state.getName());
            }
            this.mInitialState = state;
            AppMethodBeat.o(230451);
        }

        private final void transitionTo(IState iState) {
            AppMethodBeat.i(158028);
            this.mDestState = (State) iState;
            if (this.mDbg) {
                this.mSm.log("transitionTo: destState=" + this.mDestState.getName());
            }
            AppMethodBeat.o(158028);
        }

        private final void deferMessage(Message message) {
            AppMethodBeat.i(230452);
            if (this.mDbg) {
                this.mSm.log("deferMessage: msg=" + message.what);
            }
            Message obtainMessage = obtainMessage();
            obtainMessage.copyFrom(message);
            this.mDeferredMessages.add(obtainMessage);
            AppMethodBeat.o(230452);
        }

        private final void quit() {
            AppMethodBeat.i(230453);
            if (this.mDbg) {
                this.mSm.log("quit:");
            }
            sendMessage(obtainMessage(-1, mSmHandlerObj));
            AppMethodBeat.o(230453);
        }

        private final void quitNow() {
            AppMethodBeat.i(230454);
            if (this.mDbg) {
                this.mSm.log("quitNow:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
            AppMethodBeat.o(230454);
        }

        private final boolean isQuit(Message message) {
            return message.what == -1 && message.obj == mSmHandlerObj;
        }

        private final boolean isDbg() {
            return this.mDbg;
        }

        private final void setDbg(boolean z) {
            this.mDbg = z;
        }
    }

    private void initStateMachine(String str, Looper looper) {
        AppMethodBeat.i(230462);
        this.mName = str;
        this.mSmHandler = new SmHandler(looper, this);
        AppMethodBeat.o(230462);
    }

    protected StateMachine(String str) {
        AppMethodBeat.i(230463);
        this.mSmThread = new HandlerThread(str);
        this.mSmThread.start();
        initStateMachine(str, this.mSmThread.getLooper());
        AppMethodBeat.o(230463);
    }

    protected StateMachine(String str, Looper looper) {
        AppMethodBeat.i(158037);
        initStateMachine(str, looper);
        AppMethodBeat.o(158037);
    }

    protected StateMachine(String str, Handler handler) {
        AppMethodBeat.i(230464);
        initStateMachine(str, handler.getLooper());
        AppMethodBeat.o(230464);
    }

    /* access modifiers changed from: protected */
    public final void addState(State state, State state2) {
        AppMethodBeat.i(230465);
        SmHandler.access$800(this.mSmHandler, state, state2);
        AppMethodBeat.o(230465);
    }

    public final void addState(State state) {
        AppMethodBeat.i(158038);
        SmHandler.access$800(this.mSmHandler, state, null);
        AppMethodBeat.o(158038);
    }

    public final void setInitialState(State state) {
        AppMethodBeat.i(158039);
        SmHandler.access$900(this.mSmHandler, state);
        AppMethodBeat.o(158039);
    }

    public final Message getCurrentMessage() {
        AppMethodBeat.i(158040);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158040);
            return null;
        }
        Message access$1000 = SmHandler.access$1000(smHandler);
        AppMethodBeat.o(158040);
        return access$1000;
    }

    public final IState getCurrentState() {
        AppMethodBeat.i(158041);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158041);
            return null;
        }
        IState access$1100 = SmHandler.access$1100(smHandler);
        AppMethodBeat.o(158041);
        return access$1100;
    }

    public final void transitionTo(IState iState) {
        AppMethodBeat.i(158042);
        SmHandler.access$1200(this.mSmHandler, iState);
        AppMethodBeat.o(158042);
    }

    /* access modifiers changed from: protected */
    public final void transitionToHaltingState() {
        AppMethodBeat.i(230466);
        SmHandler.access$1200(this.mSmHandler, this.mSmHandler.mHaltingState);
        AppMethodBeat.o(230466);
    }

    /* access modifiers changed from: protected */
    public final void deferMessage(Message message) {
        AppMethodBeat.i(230467);
        SmHandler.access$1400(this.mSmHandler, message);
        AppMethodBeat.o(230467);
    }

    /* access modifiers changed from: protected */
    public void unhandledMessage(Message message) {
        AppMethodBeat.i(158043);
        if (this.mSmHandler.mDbg) {
            loge(" - unhandledMessage: msg.what=" + message.what);
        }
        AppMethodBeat.o(158043);
    }

    /* access modifiers changed from: protected */
    public void haltedProcessMessage(Message message) {
    }

    /* access modifiers changed from: protected */
    public void onHalting() {
    }

    /* access modifiers changed from: protected */
    public void onQuitting() {
    }

    public final String getName() {
        return this.mName;
    }

    public final void setLogRecSize(int i2) {
        AppMethodBeat.i(230468);
        this.mSmHandler.mLogRecords.setSize(i2);
        AppMethodBeat.o(230468);
    }

    public final void setLogOnlyTransitions(boolean z) {
        AppMethodBeat.i(230469);
        this.mSmHandler.mLogRecords.setLogOnlyTransitions(z);
        AppMethodBeat.o(230469);
    }

    public final int getLogRecSize() {
        AppMethodBeat.i(230470);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230470);
            return 0;
        }
        int size = smHandler.mLogRecords.size();
        AppMethodBeat.o(230470);
        return size;
    }

    public final int getLogRecCount() {
        AppMethodBeat.i(230471);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230471);
            return 0;
        }
        int count = smHandler.mLogRecords.count();
        AppMethodBeat.o(230471);
        return count;
    }

    public final LogRec getLogRec(int i2) {
        AppMethodBeat.i(230472);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230472);
            return null;
        }
        LogRec logRec = smHandler.mLogRecords.get(i2);
        AppMethodBeat.o(230472);
        return logRec;
    }

    public final Collection<LogRec> copyLogRecs() {
        AppMethodBeat.i(230473);
        Vector vector = new Vector();
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            Iterator it = smHandler.mLogRecords.mLogRecVector.iterator();
            while (it.hasNext()) {
                vector.add((LogRec) it.next());
            }
        }
        AppMethodBeat.o(230473);
        return vector;
    }

    /* access modifiers changed from: protected */
    public void addLogRec(String str) {
        AppMethodBeat.i(230474);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230474);
            return;
        }
        smHandler.mLogRecords.add(this, SmHandler.access$1000(smHandler), str, SmHandler.access$1100(smHandler), smHandler.mStateStack[smHandler.mStateStackTopIndex].state, smHandler.mDestState);
        AppMethodBeat.o(230474);
    }

    /* access modifiers changed from: protected */
    public boolean recordLogRec(Message message) {
        return true;
    }

    /* access modifiers changed from: protected */
    public String getLogRecString(Message message) {
        return "";
    }

    /* access modifiers changed from: protected */
    public String getWhatToString(int i2) {
        return null;
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final Message obtainMessage() {
        AppMethodBeat.i(230475);
        Message obtain = Message.obtain(this.mSmHandler);
        AppMethodBeat.o(230475);
        return obtain;
    }

    public final Message obtainMessage(int i2) {
        AppMethodBeat.i(158044);
        Message obtain = Message.obtain(this.mSmHandler, i2);
        AppMethodBeat.o(158044);
        return obtain;
    }

    public final Message obtainMessage(int i2, Object obj) {
        AppMethodBeat.i(158045);
        Message obtain = Message.obtain(this.mSmHandler, i2, obj);
        AppMethodBeat.o(158045);
        return obtain;
    }

    public final Message obtainMessage(int i2, int i3) {
        AppMethodBeat.i(230476);
        Message obtain = Message.obtain(this.mSmHandler, i2, i3, 0);
        AppMethodBeat.o(230476);
        return obtain;
    }

    public final Message obtainMessage(int i2, int i3, int i4) {
        AppMethodBeat.i(230477);
        Message obtain = Message.obtain(this.mSmHandler, i2, i3, i4);
        AppMethodBeat.o(230477);
        return obtain;
    }

    public final Message obtainMessage(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(230478);
        Message obtain = Message.obtain(this.mSmHandler, i2, i3, i4, obj);
        AppMethodBeat.o(230478);
        return obtain;
    }

    public final void sendMessage(int i2) {
        AppMethodBeat.i(158046);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158046);
            return;
        }
        smHandler.sendMessage(obtainMessage(i2));
        AppMethodBeat.o(158046);
    }

    public final void sendMessage(int i2, Object obj) {
        AppMethodBeat.i(230479);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230479);
            return;
        }
        smHandler.sendMessage(obtainMessage(i2, obj));
        AppMethodBeat.o(230479);
    }

    public final void sendMessage(int i2, int i3) {
        AppMethodBeat.i(230480);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230480);
            return;
        }
        smHandler.sendMessage(obtainMessage(i2, i3));
        AppMethodBeat.o(230480);
    }

    public final void sendMessage(int i2, int i3, int i4) {
        AppMethodBeat.i(230481);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230481);
            return;
        }
        smHandler.sendMessage(obtainMessage(i2, i3, i4));
        AppMethodBeat.o(230481);
    }

    public final void sendMessage(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(230482);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230482);
            return;
        }
        smHandler.sendMessage(obtainMessage(i2, i3, i4, obj));
        AppMethodBeat.o(230482);
    }

    public final void sendMessage(Message message) {
        AppMethodBeat.i(230483);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230483);
            return;
        }
        smHandler.sendMessage(message);
        AppMethodBeat.o(230483);
    }

    public final void sendMessageDelayed(int i2, long j2) {
        AppMethodBeat.i(230484);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230484);
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i2), j2);
        AppMethodBeat.o(230484);
    }

    public final void sendMessageDelayed(int i2, Object obj, long j2) {
        AppMethodBeat.i(230485);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230485);
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i2, obj), j2);
        AppMethodBeat.o(230485);
    }

    public final void sendMessageDelayed(int i2, int i3, long j2) {
        AppMethodBeat.i(230486);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230486);
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i2, i3), j2);
        AppMethodBeat.o(230486);
    }

    public final void sendMessageDelayed(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(230487);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230487);
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i2, i3, i4), j2);
        AppMethodBeat.o(230487);
    }

    public final void sendMessageDelayed(int i2, int i3, int i4, Object obj, long j2) {
        AppMethodBeat.i(230488);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230488);
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i2, i3, i4, obj), j2);
        AppMethodBeat.o(230488);
    }

    public final void sendMessageDelayed(Message message, long j2) {
        AppMethodBeat.i(230489);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230489);
            return;
        }
        smHandler.sendMessageDelayed(message, j2);
        AppMethodBeat.o(230489);
    }

    /* access modifiers changed from: protected */
    public final void sendMessageAtFrontOfQueue(int i2) {
        AppMethodBeat.i(158047);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158047);
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i2));
        AppMethodBeat.o(158047);
    }

    /* access modifiers changed from: protected */
    public final void sendMessageAtFrontOfQueue(int i2, Object obj) {
        AppMethodBeat.i(230490);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230490);
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i2, obj));
        AppMethodBeat.o(230490);
    }

    /* access modifiers changed from: protected */
    public final void sendMessageAtFrontOfQueue(int i2, int i3) {
        AppMethodBeat.i(230491);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230491);
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i2, i3));
        AppMethodBeat.o(230491);
    }

    /* access modifiers changed from: protected */
    public final void sendMessageAtFrontOfQueue(int i2, int i3, int i4) {
        AppMethodBeat.i(230492);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230492);
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i2, i3, i4));
        AppMethodBeat.o(230492);
    }

    /* access modifiers changed from: protected */
    public final void sendMessageAtFrontOfQueue(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(230493);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230493);
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i2, i3, i4, obj));
        AppMethodBeat.o(230493);
    }

    /* access modifiers changed from: protected */
    public final void sendMessageAtFrontOfQueue(Message message) {
        AppMethodBeat.i(230494);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230494);
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(message);
        AppMethodBeat.o(230494);
    }

    /* access modifiers changed from: protected */
    public final void removeMessages(int i2) {
        AppMethodBeat.i(230495);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230495);
            return;
        }
        smHandler.removeMessages(i2);
        AppMethodBeat.o(230495);
    }

    /* access modifiers changed from: protected */
    public final boolean isQuit(Message message) {
        AppMethodBeat.i(230496);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            boolean access$2100 = SmHandler.access$2100(smHandler, message);
            AppMethodBeat.o(230496);
            return access$2100;
        } else if (message.what == -1) {
            AppMethodBeat.o(230496);
            return true;
        } else {
            AppMethodBeat.o(230496);
            return false;
        }
    }

    public final void quit() {
        AppMethodBeat.i(158048);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158048);
            return;
        }
        SmHandler.access$2200(smHandler);
        AppMethodBeat.o(158048);
    }

    public final void quitNow() {
        AppMethodBeat.i(158049);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158049);
            return;
        }
        SmHandler.access$2300(smHandler);
        AppMethodBeat.o(158049);
    }

    public boolean isDbg() {
        AppMethodBeat.i(230497);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(230497);
            return false;
        }
        boolean access$2400 = SmHandler.access$2400(smHandler);
        AppMethodBeat.o(230497);
        return access$2400;
    }

    public void setDbg(boolean z) {
        AppMethodBeat.i(158050);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158050);
            return;
        }
        SmHandler.access$2500(smHandler, z);
        AppMethodBeat.o(158050);
    }

    public void start() {
        AppMethodBeat.i(158051);
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            AppMethodBeat.o(158051);
            return;
        }
        SmHandler.access$2600(smHandler);
        AppMethodBeat.o(158051);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(230498);
        printWriter.println(getName() + ":");
        printWriter.println(" total records=" + getLogRecCount());
        for (int i2 = 0; i2 < getLogRecSize(); i2++) {
            try {
                printWriter.printf(" rec[%d]: %s\n", Integer.valueOf(i2), getLogRec(i2).toString());
                printWriter.flush();
            } catch (Exception e2) {
            }
        }
        printWriter.println("curState=" + getCurrentState().getName());
        AppMethodBeat.o(230498);
    }

    /* access modifiers changed from: protected */
    public void logAndAddLogRec(String str) {
        AppMethodBeat.i(230499);
        addLogRec(str);
        log(str);
        AppMethodBeat.o(230499);
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
    }

    /* access modifiers changed from: protected */
    public void logd(String str) {
    }

    /* access modifiers changed from: protected */
    public void logv(String str) {
    }

    /* access modifiers changed from: protected */
    public void logi(String str) {
    }

    /* access modifiers changed from: protected */
    public void logw(String str) {
    }

    /* access modifiers changed from: protected */
    public void loge(String str) {
    }

    /* access modifiers changed from: protected */
    public void loge(String str, Throwable th) {
    }
}
