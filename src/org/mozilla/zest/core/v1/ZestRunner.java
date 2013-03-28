/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.zest.core.v1;

import java.io.File;
import java.io.IOException;

public interface ZestRunner {

	void run (ZestScript script) 
			throws ZestTransformFailException, ZestAssertFailException, ZestActionFailException, IOException;

	void runScript (File script) 
			throws ZestTransformFailException, ZestAssertFailException, ZestActionFailException, IOException;
	
	ZestResponse runStatement(ZestScript script, ZestStatement stmt, ZestResponse lastResponse) 
			throws ZestAssertFailException, ZestActionFailException, ZestTransformFailException, IOException;

	ZestResponse send (ZestRequest request) throws ZestTransformFailException, IOException;
	
	void handleResponse (ZestRequest request, ZestResponse response) 
			throws ZestTransformFailException, ZestAssertFailException, ZestActionFailException;
	
	void handleTransforms(ZestScript script, ZestRequest request, ZestResponse response) throws ZestTransformFailException;
	
	void handleTransform (ZestRequest request, ZestTransformation transform) throws ZestTransformFailException;

	String handleAction(ZestScript script, ZestAction action, ZestResponse lastResponse) throws ZestActionFailException;

	String getReplacementValue(ZestFieldDefinition defn);
	
	void responsePassed (ZestRequest request, ZestResponse response, ZestAssertion assertion);

	void responseFailed (ZestRequest request, ZestResponse response, ZestAssertion assertion) throws ZestAssertFailException;
	
	void setStopOnAssertFail(boolean stop);
	
	void setStopOnTestFail(boolean stop);

	boolean getStopOnAssertFail();
	
	boolean getStopOnTestFail();
	
	void setProxy(String host, int port);

}
