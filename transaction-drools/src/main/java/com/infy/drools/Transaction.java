package com.infy.drools;

public class Transaction {

	public enum TranscType {
		SELF, THIRDPARTY;
	}

	private TranscType txntype;
	private long amt;
	private boolean validTxn;

	public TranscType getTxntype() {
		return txntype;
	}

	public void setTxntype(TranscType txntype) {
		this.txntype = txntype;
	}

	public long getAmt() {
		return amt;
	}

	public void setAmt(long amt) {
		this.amt = amt;
	}

	public boolean isValidTxn() {
		return validTxn;
	}

	public void setValidTxn(boolean validTxn) {
		this.validTxn = validTxn;
	}

	public Transaction(TranscType txntype, long amt) {
		super();
		this.txntype = txntype;
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Transaction [txntype=" + txntype + ", amt=" + amt + ", validTxn=" + validTxn + "]";
	}



}
