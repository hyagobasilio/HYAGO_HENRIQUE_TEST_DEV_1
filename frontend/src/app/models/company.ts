import { Stock } from './stock';

export interface Company {

    id: number;
    name: string;
    segment: string;
    stocks: Stock[]
}
