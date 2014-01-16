package com.tjeannin.provigen.test.constraint;

import android.content.ContentValues;

import com.tjeannin.provigen.InvalidContractException;
import com.tjeannin.provigen.test.ExtendedProviderTestCase;
import com.tjeannin.provigen.test.constraint.ConstraintsProvider.NotNullContract;
import com.tjeannin.provigen.test.constraint.ConstraintsProvider.UniqueContract;

public class ConstraintsTest extends ExtendedProviderTestCase<ConstraintsProvider> {

	public ConstraintsTest() {
		super(ConstraintsProvider.class, "com.test.simple");
	}

	public void testNotNullAnnotation() throws InvalidContractException {

		ContentValues contentValuesWithNull = getContentValues(NotNullContract.class);
		contentValuesWithNull.putNull(NotNullContract.AN_INT);

		ContentValues normalContentValues = getContentValues(NotNullContract.class);

		assertEquals(0, getRowCount(NotNullContract.CONTENT_URI));
		getMockContentResolver().insert(NotNullContract.CONTENT_URI, contentValuesWithNull);
		assertEquals(0, getRowCount(NotNullContract.CONTENT_URI));
		getMockContentResolver().insert(NotNullContract.CONTENT_URI, normalContentValues);
		assertEquals(1, getRowCount(NotNullContract.CONTENT_URI));
		getMockContentResolver().insert(NotNullContract.CONTENT_URI, contentValuesWithNull);
		assertEquals(1, getRowCount(NotNullContract.CONTENT_URI));
	}

	public void testUniqueAnnotation() throws InvalidContractException {

		getMockContentResolver().insert(UniqueContract.CONTENT_URI, getContentValues(UniqueContract.class));
		getMockContentResolver().insert(UniqueContract.CONTENT_URI, getContentValues(UniqueContract.class));
		getMockContentResolver().insert(UniqueContract.CONTENT_URI, getContentValues(UniqueContract.class));

		assertEquals(1, getRowCount(UniqueContract.CONTENT_URI));
	}
}