package com.infy;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


import com.infy.drools.Transaction;
import com.infy.drools.Transaction.TranscType;

public class App {
	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * SpreadsheetCompiler converter = new SpreadsheetCompiler(); final String drl =
		 * converter.compile( new FileInputStream(new File(
		 * "E:\\programmertechExamples\\JEE\\DroolsDecisionTable\\drooolsValidate\\src\\main\\resources\\statefulPkg\\ValidateApplicant.xlsx"
		 * )), InputType.XLS); System.out.println(drl);
		 */
		Set<Transaction> trns = new HashSet<>();
		
		trns.add(new Transaction(TranscType.SELF,100));
		
		
		/*tr.add(new Applicant(2, "Ram", "25/03/1905", "M"));
		tr.add(new Applicant(3, "Anjali", "25/03/1993", "F"));
		tr.add(new Applicant(4, "Rani", "01/07/1945", "F"));*/
		
		executeStatefull(trns);

		for (Transaction tx : trns) {
			
			System.out.println(tx.toString());
		}

	}

	public static void executeStatefull(Set<Transaction> trns) {
			try {
				// load up the knowledge base
				KieServices ks = KieServices.Factory.get();
				KieContainer kContainer = ks.getKieClasspathContainer();
				KieBase kBase = kContainer.getKieBase("stateful");
				KieSession kSession = kBase.newKieSession();
				/*kSession.addEventListener(new DebugAgendaEventListener());
				kSession.addEventListener(new DebugRuleRuntimeEventListener());*/
				for (Transaction tr : trns) {
					kSession.insert(tr);
					kSession.fireAllRules();
				}
				
				kSession.dispose();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
}
