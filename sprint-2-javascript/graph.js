// Simula una "base de datos" de ciudades y sus conexiones
const cityData = {
    'Mexico City': { connections: { 'Querétaro': 212, 'Puebla': 130 } },
    'Querétaro': { connections: { 'Mexico City': 212, 'San Miguel de Allende': 65 } },
    'Puebla': { connections: { 'Mexico City': 130 } },
    'San Miguel de Allende': { connections: { 'Querétaro': 65 } }
};

/**
 * Encuentra las ciudades cercanas a un destino dado.
 * @param {string} destination - La ciudad de origen.
 * @param {object} database - La base de datos de ciudades.
 * @returns {Array<object>} Un array de objetos, cada uno con 'city' y 'distance'.
 */
function getNearbyCities(destination, database = cityData) {
    // Validación de datos de entrada
    if (!destination || typeof destination !== 'string') {
        throw new Error('Destination must be a non-empty string.');
    }

    const city = database[destination];

    // Manejo de caso de borde: la ciudad no existe
    if (!city) {
        return [];
    }

    // Transforma el objeto de conexiones en el formato de salida requerido
    const nearby = Object.keys(city.connections).map(cityName => {
        return {
            city: cityName,
            distance: city.connections[cityName]
        };
    });

    return nearby;
}

// Exportamos la función para que Jest pueda importarla y probarla
module.exports = getNearbyCities;