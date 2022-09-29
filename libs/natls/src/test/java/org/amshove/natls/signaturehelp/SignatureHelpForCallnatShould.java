package org.amshove.natls.signaturehelp;

import org.amshove.testhelpers.IntegrationTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@IntegrationTest
class SignatureHelpForCallnatShould extends SignatureHelpTest
{
	@Test
	void haveTheCompleteSignatureAsLabel() throws ExecutionException, InterruptedException, TimeoutException
	{
		var help = getSignatureHelpForParameterList("CALLNAT 'CALLED' ${}$");
		var signature = help.getSignatures().get(0);
		assertThat(signature.getLabel()).isEqualTo("CALLED (USING APDA, P-OPTIONAL :(A10) OPTIONAL, P-NUMBER :(N12))");
	}

	@Test
	void haveTheFirstParameterActiveWhenCursorIsAfterModuleName() throws ExecutionException, InterruptedException, TimeoutException
	{
		var help = getSignatureHelpForParameterList("CALLNAT 'CALLED'${}$");
		var signature = help.getSignatures().get(0);

		assertThat(help.getActiveParameter()).isEqualTo(1);
		assertThat(signature.getParameters().get(0).getLabel().getLeft()).isEqualTo("USING APDA");
	}

	@Test
	void haveTheSecondParameterActiveWhenCursorIsAfterFirstParameter() throws ExecutionException, InterruptedException, TimeoutException
	{
		var help = getSignatureHelpForParameterList("CALLNAT 'CALLED' APDA${}$");

		assertThat(help.getActiveParameter()).isEqualTo(1);
	}

	@Test
	void haveTheSecondParameterActiveWhenCursorIsInTheSecondParameter() throws ExecutionException, InterruptedException, TimeoutException
	{
		var help = getSignatureHelpForParameterList("CALLNAT 'CALLED' APDA 'Lit${}$eral'");

		assertThat(help.getActiveParameter()).isEqualTo(1);
	}

	@Override
	protected String getCalledModuleFilename()
	{
		return "CALLED.NSN";
	}

	@Override
	protected String getCalledModuleSource()
	{
		return """
			DEFINE DATA
			PARAMETER USING APDA
			PARAMETER
			1 P-OPTIONAL (A10) OPTIONAL
			1 P-NUMBER (N12)
			END-DEFINE
						
			END
			""";
	}
}
