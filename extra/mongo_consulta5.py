import pymongo

# Conecta a tu servidor de MongoDB
client = pymongo.MongoClient('mongodb://user:1234@ac-idgyi4w-shard-00-00.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-01.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-02.ciwruv5.mongodb.net/?replicaSet=atlas-u9kl0f-shard-0&ssl=true&authSource=admin')

# Selecciona la base de datos y la colección de destino
db = client['proyecto']
collection = db['Videojuego']

# Consulta
pipeline = [
    {
        "$group": {
            "_id": "$genero",
            "rating": {
                "$avg": "$rating"
            },
            "ratingCount": {
                "$sum": "$ratingCount"
            }
        }
    },
    {
        "$sort": {
            "rating": -1
        }
    },
    {
        "$limit": 10
    }
]

# Ejecución de la consulta
resultados = collection.aggregate(pipeline)

# Impresión de los resultados
for resultado in resultados:
    print(resultado)
