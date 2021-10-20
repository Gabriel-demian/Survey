# Survey

## Service Architecture
![NubiEncuestas (1)](https://user-images.githubusercontent.com/57782295/138152930-d53dedd6-5e4e-46aa-961c-4ffaafd11fa7.jpeg)

## Database Diagram
![ERD de Survey](https://user-images.githubusercontent.com/57782295/138152933-22cd5ffb-9f33-46bf-a13b-8444f2842771.jpeg)



# Endpoints


## Create a new survey
Request URL http://localhost:8080/newSurvey
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
