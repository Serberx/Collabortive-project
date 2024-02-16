package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.markerInterfaces.ApiMarker;
import jakarta.persistence.PersistenceException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ApiMarker.class) //alles was unter ApiMarker ist wird gefunden | assignableTypes() für bestimmte Controller
public class AdviceGlobalRestController{

    @ExceptionHandler(PersistenceException.class) //sobald dieser Excep.Handl. mehrmals gebraucht wird, rausziehen damit es mehrmals genutzt werden kann.
    public HttpEntity<ProblemDetail> handlePersistenceException(PersistenceException pEx){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,
                                                                       pEx.getMessage());
        problemDetail.setTitle("Persistence Problems");
        return ResponseEntity.status(status)
                             .body(problemDetail);
    }
}

