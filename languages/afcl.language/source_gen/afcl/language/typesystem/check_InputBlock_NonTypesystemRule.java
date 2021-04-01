package afcl.language.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import org.jetbrains.mps.openapi.language.SProperty;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import org.jetbrains.mps.openapi.language.SConcept;

public class check_InputBlock_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_InputBlock_NonTypesystemRule() {
  }
  public void applyRule(final SNode inputBlock, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    Set<String> inNames = SetSequence.fromSet(new HashSet<String>());
    for (SNode inName : ListSequence.fromList(SLinkOperations.getChildren(inputBlock, LINKS.inputs$RVyg))) {
      if (SetSequence.fromSet(inNames).contains(SPropertyOperations.getString(inName, PROPS.name$MnvL))) {
        {
          final MessageTarget errorTarget = new NodeMessageTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(inName, "Duplicate input data name: " + SPropertyOperations.getString(inName, PROPS.name$MnvL), "r:f92fbf43-f5be-404a-8369-1fbbf8cc1fe6(afcl.language.typesystem)", "5691044914556141711", null, errorTarget);
        }
      }
      SetSequence.fromSet(inNames).addElement(SPropertyOperations.getString(inName, PROPS.name$MnvL));
    }
  }
  public SAbstractConcept getApplicableConcept() {
    return CONCEPTS.InputBlock$Y0;
  }
  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    return new IsApplicableStatus(argument.getConcept().isSubConceptOf(getApplicableConcept()), null);
  }
  public boolean overrides() {
    return false;
  }

  private static final class PROPS {
    /*package*/ static final SProperty name$MnvL = MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name");
  }

  private static final class LINKS {
    /*package*/ static final SContainmentLink inputs$RVyg = MetaAdapterFactory.getContainmentLink(0xec3060ee1f234e47L, 0xaf803618736238b3L, 0x658fbcf6b68e2597L, 0x658fbcf6b68e4f1cL, "inputs");
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept InputBlock$Y0 = MetaAdapterFactory.getConcept(0xec3060ee1f234e47L, 0xaf803618736238b3L, 0x658fbcf6b68e2597L, "afcl.language.structure.InputBlock");
  }
}