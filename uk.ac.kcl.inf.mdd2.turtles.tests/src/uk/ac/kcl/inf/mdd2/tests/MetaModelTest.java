package uk.ac.kcl.inf.mdd2.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.jupiter.api.Test;

import uk.ac.kcl.inf.mdd2.turtles.TurtlesPackage;

class MetaModelTest {
	
	@Test
	public void testREALDegrees() {
		EClassifier turnStatement = TurtlesPackage.eINSTANCE.getEClassifier("TurnStatement");
		assertNotNull(turnStatement, "Missing 'TurnStatement' definition.");
		
		if (turnStatement instanceof EClass) {
			EStructuralFeature degreesFeature = ((EClass) turnStatement).getEStructuralFeature("degrees");
			assertNotNull(degreesFeature, "Missing feature 'degrees' in 'TurnStatement'.");
			
			assertEquals("EFloat", degreesFeature.getEType().getName(), "Wrong type for degreesFeature.");
		} else {
			throw new AssertionError("'TurnStatement' not a valid meta-class.");
		}
	}	
}
