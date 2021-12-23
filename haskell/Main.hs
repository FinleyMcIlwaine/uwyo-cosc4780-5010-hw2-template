module Main where

import ParRegExp ( pRegExp, myLexer )
import System.Exit (die)

main :: IO ()
main = do
  c <- getContents
  case pRegExp (myLexer c) of
    Left _ -> die "parse error! try testing with the bnfc generated modules (`make parse`)"
    Right tree -> undefined
