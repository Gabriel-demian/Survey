# Survey

### Specifications requested for the software. 
[Evaluación Técnica.docx](https://github.com/Gabriel-demian/Survey/files/7383837/Evaluacion.Tecnica.docx)

## Service Architecture
![NubiEncuestas (1)](https://user-images.githubusercontent.com/57782295/138152930-d53dedd6-5e4e-46aa-961c-4ffaafd11fa7.jpeg)

## Database Diagram
![ERD de Survey](https://user-images.githubusercontent.com/57782295/138152933-22cd5ffb-9f33-46bf-a13b-8444f2842771.jpeg)



# Endpoints
### Postman Collection:
https://www.getpostman.com/collections/a2c6d46e74b227b5bdf5
    
    	POST-> /user
	POST-> /login
	POST-> /newSurvey (necesita estar registrado para crear nuevas encuestas)
	POST-> /survey/{surveyId}/{answerId}
	GET -> /survey/{surveyId}
	GET -> /surveyList
	GET -> /surveyList/user/{userName}
	GET -> /surveyList/label/{label}
	GET -> /randomSurvey

## 1_ create a new user
![newUser](https://user-images.githubusercontent.com/57782295/138156277-4a3e41c9-4aa7-4eaf-9c2d-595603979fff.PNG)

## 2_ login to get the token
![login](https://user-images.githubusercontent.com/57782295/138156292-3d355cc5-e365-41a0-8535-7ec513938388.PNG)

## Create a new survey
![newSurvey1](https://user-images.githubusercontent.com/57782295/138156299-a2867750-5e03-4a9a-8a52-dc27fdb88a88.PNG)

![newSurvey2](https://user-images.githubusercontent.com/57782295/138156307-154879a8-b351-4b89-9e89-2a57b0b57023.PNG)
```
{
    "createdBy": "Gabi",
    "survey": "Do you like the color blue?",
    "answers": [
        {
            "answer": "I love it"
        },
        {
            "answer": "It is ok.."
        },
        {
            "answer": "Meee"
        },
        {
            "answer": "I hate it"
        }
    ],
    "label": "colors"
}

```
