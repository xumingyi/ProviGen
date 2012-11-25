package com.tjeannin.provigen.test;

import android.net.Uri;

import com.tjeannin.provigen.InvalidContractException;
import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.ProviGenProvider;
import com.tjeannin.provigen.Type;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;
import com.tjeannin.provigen.annotation.Contract;

public class SimpleContentProvider extends ProviGenProvider {

	public SimpleContentProvider() throws InvalidContractException {
		super(SimpleContractVersionOne.class);
	}

	@Contract(version = 1)
	public static interface SimpleContractVersionOne extends ProviGenBaseContract {

		@Column(type = Type.INTEGER)
		public static final String COLUMN_INT = "int";

		@ContentUri
		public static final Uri CONTENT_URI = Uri.parse("content://com.test.simple/table_name_simple");

	}

	@Contract(version = 2)
	public static interface SimpleContractVersionTwo extends ProviGenBaseContract {

		@Column(type = Type.INTEGER)
		public static final String COLUMN_INT = "int";

		@Column(type = Type.TEXT)
		public static final String COLUMN_STRING = "string";

		@Column(type = Type.REAL)
		public static final String COLUMN_REAL = "hour";

		@ContentUri
		public static final Uri CONTENT_URI = Uri.parse("content://com.test.simple/table_name_simple");

	}

}
